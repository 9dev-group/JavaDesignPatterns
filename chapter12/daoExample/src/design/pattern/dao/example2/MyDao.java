package design.pattern.dao.example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public MyDao(){
		
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void insert(MyDto dto){
		try{
			String query = "INSERT INTO TEST(Name, Age) VALUES (?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(query);
			ptmt.setString(1, dto.getName());
			ptmt.setInt(2, dto.getAge());
			ptmt.executeUpdate();
			System.out.println("데이터를 정상 입력하였습니다.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(ptmt != null)
					ptmt.close();
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void select(){
		try{
			String query = "SELECT * FROM TEST";
			connection = getConnection();
			ptmt = connection.prepareStatement(query);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()){
			  System.out.println("이름:"+resultSet.getString("Name")+"|나이:"+resultSet.getInt("Age"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(resultSet != null)
					resultSet.close();
				if(ptmt != null)
					ptmt.close();
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
