package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infy.utility.ConnectionProvider;

public class DealerDao {
	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;
	
	
	public  List<Item> viewOwnStock( String dealerId) {
		
		List<Item> itemList= new ArrayList<>();
	try {
		con = ConnectionProvider.getConnection();
		
			ps = con.prepareStatement("select * from dealer_stock where dealerId=?");
		ps.setString(1, dealerId);
		rs = ps.executeQuery();
		while (rs.next()) {
			
			ps = con.prepareStatement("select * from items where itemId=?");
			String itemId=rs.getString(2);
			ps.setString(1, itemId);
			rs=ps.executeQuery();
			while(rs.next()){
				 String itemId1	=rs.getString(1);
				 String name= rs.getString(2);
				float price =	rs.getFloat(3);
				Item item=new Item(itemId1, name, price);
				System.out.println(item);
				itemList.add(new Item(itemId1, name, price) );
				
			}
			return itemList;
		}
		
	}
		 catch (SQLException e) {
				
				e.printStackTrace();
			}
	return itemList;
		
	}
	
	public void updateDealerStock(int quantity,String itemId)
	{
		con = ConnectionProvider.getConnection();
		try {
			ps=con.prepareStatement("update dealer_stock set quantity=quantity-? where itemId=?");
			ps.setInt(1, quantity);
			ps.setString(2, itemId);
			int x=ps.executeUpdate();
			System.out.println("the updated rows are:---"+x);
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
		
	
	
	
	
	
	
	
	

}
