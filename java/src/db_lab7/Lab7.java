package db_lab7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

//import org.sqlite.*;

public class Lab7 {
	
	public static boolean initWarehouse(Statement stat){
		try {
			stat.executeUpdate("drop table if exists warehouse;");
		} catch (SQLException sqle) {
			System.out.println("existing warehouse table not dropped");
			System.out.println(sqle.getMessage());
			return false;
		}	try {
			stat.executeUpdate("create table if not exists warehouse ("
					+ "w_warehousekey decimal(3,0) primary key"
					+ ", w_name char(25) not null"
					+ ", w_supplierkey decimal(2,0) not null"
					+ ", w_capacity decimal(6,2) not null"
					+ ", w_address varchar(40) not null"
					+ ", w_nationkey decimal(2,0) not null"
					+ ");");
			
		} catch (SQLException sqle) {
			System.out.println("table not created");
			System.out.println(sqle.getMessage());
			return false;
		}
		return true;
	}

	public String formattedSupplier(Integer supplier){
		return String.format("Supplier#%09d", supplier);
	}
	/*public String formattedNation(Integer nation){
		return String.format("Nation#%09d", nation);
	}*/

	
	public static boolean newEntry(Statement stat){
		String name, address, supplierString, nationString;
		Integer supplier, capacity, nation;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name:");
		name = scan.nextLine();
		System.out.println("Enter address:");
		address = scan.nextLine();
		System.out.println("Enter supplier (String or digit):");
		supplierString = scan.nextLine();
		//if(supplierString.toLowerCase().contains("supplier")){
			
		//}
		supplier = Integer.parseInt(supplierString
				.toLowerCase()
				.replaceAll("[A-z]", ""));
		System.out.println("Enter capacity (digit):");
		capacity = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter nation (String or digit):");
		nationString = scan.nextLine();
		
		/*nation = Integer.parseInt(nationString
				.toLowerCase()
				.replaceAll("[A-z]", ""));
		 */
		if(nationString.length()>0 &&
				!nationString.matches("^[A-z]$")){
			nation = Integer.parseInt(nationString);
		}else{
			try{
				ResultSet nationQuery = stat.executeQuery(String.format(
						"select n_nationkey"
						+ "from nation"
						+ "where lower(n_name) = '%s'", nationString.toLowerCase()));
				if(nationQuery.next()){
					nation = nationQuery.getInt("n_nationkey");
				}
			}catch(SQLException sqle){
				System.out.println(String.format(
						"failed to match nation string '%s' with"
						+ " nation key.", nationString.toLowerCase()));
			}
			return false;
		}
		try {/*
			System.out.println(
					String.format("insert into warehouse ("
							+ "w_name"
							+ ", w_supplierkey"
							+ ", w_capacity"
							+ ", w_address"
							+ ", w_nationkey"
							+ ") values ('%s', %d, %d, '%s', %d);"
							, name, supplier, capacity, address, nation));
			*/
			/*System.out.println(String.format("insert into warehouse ("
					+ "w_warehousekey"
					+ ", w_name"
					+ ", w_supplierkey"
					+ ", w_capacity"
					+ ", w_address"
					+ ", w_nationkey"
					+ ") values (NULL, '%s', %d, %d, '%s', %d);"
					, name, supplier, capacity, address, nation));
			*/
			stat.executeUpdate(String.format("insert into warehouse ("
					+ "w_warehousekey"
					+ ", w_name"
					+ ", w_supplierkey"
					+ ", w_capacity"
					+ ", w_address"
					+ ", w_nationkey"
					+ ") values (NULL, '%s', %d, %d, '%s', %d);"
					, name, supplier, capacity, address, nation));
					
		} catch (SQLException sqle) {
			System.out.println("insert failed.");
			System.out.println(sqle.getMessage());
			return false;
		}
		return true;
	}
	
	
	
	public static boolean warehouseTest(Statement stat){
		
		try {
			
			ResultSet foobar = stat.
					executeQuery("select *"
							+ "from warehouse;");
			
			while(foobar.next()){
				
				Integer wkey = foobar.getInt("w_warehousekey");
				String wname = foobar.getString("w_name");
				Integer wskey = foobar.getInt("w_supplierkey");
				Integer wcap = foobar.getInt("w_capacity");
				String wadd = foobar.getString("w_address");
				Integer wnkey = foobar.getInt("w_nationkey");
				
				System.out.println(String.format("%d %s %d %d %s %d",
						wkey, wname, wskey, wcap, wadd, wnkey));
			}
		} catch (SQLException sqle) {
			System.out.println("warehouse test failed.");
			System.out.println(sqle.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean warehouseCapacity(Statement stat
			, Integer capacityMin, String suppName){
		
		try {
			// for every supplier find the total capacity of warehouses
			ResultSet capacityPerSupplier = stat.
					executeQuery("select s_name, sum(w_capacity) "
							+ "from supplier inner join warehouse "
							+ "on s_suppkey = w_supplierkey "
							+ "group by s_name;");
			System.out.println("Total capacities of suppliers");
			while(capacityPerSupplier.next()){
				String nm = capacityPerSupplier.getString("s_name");
				Integer cap = capacityPerSupplier.getInt("sum(w_capacity)");
				System.out.println(String.format(
						"supplier: %s  capacity: %d", nm, cap));
			}
		} catch (SQLException sqle) {
			System.out.println("group by suppliers failed.");
			System.out.println(sqle.getMessage());
			return false;
		}
		try {
			// supplier with biggest number of warehouses
			ResultSet mostWarehouses = stat.
					executeQuery("select s_name, count(w_capacity) "
							+ "from supplier inner join warehouse "
							+ "on s_suppkey = w_supplierkey "
							+ "group by s_name "
							+ "having count(w_capacity) = ("
							+ "	select count(w_capacity)"
							+ "	from warehouse"
							+ "	group by w_supplierkey"
							+ "	order by count(w_capacity) desc"
							+ "	limit 1);");
			System.out.println("-------------------------");
			System.out.println("Suppliers with largest # of warehouses");
			while(mostWarehouses.next()){
				String nm = mostWarehouses.getString("s_name");
				Integer cap = mostWarehouses.getInt("count(w_capacity)");
				System.out.println(String.format(
						"supplier: %s  # warehouses: %d", nm, cap));
			}
		} catch (SQLException sqle) {
			System.out.println("supplier with most warehouses failed.");
			System.out.println(sqle.getMessage());
			return false;
		}
	
		try {
			// warehouses in Asia with capacity greater than min given
			ResultSet warehousesAsia = stat.
					executeQuery(String.format("select w_name, n_name, w_capacity "
							+ "from warehouse "
							+ "inner join nation "
							+ "inner join region "
							+ "on w_nationkey = n_nationkey "
							+ "and n_regionkey = r_regionkey "
							+ "and r_name = 'ASIA' "
							+ "where w_capacity > %d", capacityMin));
			System.out.println("-------------------------");
			System.out.println(String.format(
					"Warehouses in Asia with a capacity > %d", capacityMin));
			while(warehousesAsia.next()){
				String warehouseName = warehousesAsia.getString("w_name");
				String nationName = warehousesAsia.getString("n_name");
				Integer cap = warehousesAsia.getInt("w_capacity");
				System.out.println(String.format(
						"warehouse: %s nation: %s capacity: %d", warehouseName, nationName, cap));
			}
		} catch (SQLException sqle) {
			System.out.println("warehouses in Asia failed.");
			System.out.println(sqle.getMessage());
			return false;
		}
		
		try {
			// supplier warehouses fitting products
			ResultSet capacitySet = stat.
					executeQuery(String.format("select sum(w_capacity) "
							+ "from warehouse "
							+ "where w_supplierkey = %d;",
							Integer.parseInt(
									suppName.replace("[A-z]", ""))));
			Integer cap = capacitySet.getInt(1);
			ResultSet partNumSet = stat.
					executeQuery(String.format("select sum(ps_availqty) "
							+ "from partsupp inner join supplier "
							+ "on ps_suppkey = s_suppkey "
							+ "and s_suppkey = %d;",
							Integer.parseInt(
									suppName.replace("[A-z]", ""))));
			
			
			Integer partNum = partNumSet.getInt(1);
			System.out.println("-------------------------");
			System.out.println("Capacity/inventory comparison");
			System.out.println(String.format(
					"Warehouses of supplier %s, #%d, have total capacity %d and total inventory %d.",
					suppName, Integer.parseInt(suppName.replace("[A-z]", ""))
						,cap, partNum));
			if(cap < partNum){
				System.out.println("Warehouses of supplier " + suppName + " inadequate.");
			}else{
				System.out.println("Warehouses of supplier " + suppName + " adequate.");
			}
			
		} catch (SQLException sqle) {
			System.out.println("fitting warhouses failed");
			System.out.println(sqle.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static boolean closeConn(Connection conn){
		try{
			conn.close();
		}catch(SQLException sqle){
			System.out.println(sqle.getMessage());
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner mainScan = new Scanner(System.in);
		Class jdbc = Class.forName("org.sqlite.JDBC");
		Connection conn;
		Statement stat;
		
		System.out.println("1: Connect to DB");
		System.out.println("2: Initiate table 'Warehouse'");
		System.out.println("3: Take a new 'Warehouse' entry");
		System.out.println("4: Collect 'Warehouse' information");
		System.out.println("5: Close DB connection");
		
		System.out.print("Enter choice: ");
		Integer scanIn = mainScan.nextInt();
		mainScan.nextLine();
		conn = DriverManager.getConnection("jdbc:sqlite:lab3db");
		stat = conn.createStatement();
		
		
		//warehouseTest(stat);
		
		
		while(scanIn > 0 && scanIn < 5){
			
			switch(scanIn){
			case 1:
				if(!conn.isClosed())
					conn.close();
				conn = DriverManager.getConnection("jdbc:sqlite:lab3db");
				stat = conn.createStatement();
				break;
			case 2:
				initWarehouse(stat);
				break;
			case 3:
				newEntry(stat);
				break;
			case 4:
				Integer capMin;
				String suppName;
				System.out.println("Enter capacity lower bound, exclusive:");
				
				try {
					String capMinString = mainScan.nextLine();
					capMin = Integer.parseInt(capMinString);
				}catch(NumberFormatException nfe){
					System.out.println("not a number...");
					System.out.println(nfe.getMessage());
					break;
				}
				
				System.out.println("Enter supplier name (string):");
				suppName = mainScan.nextLine();
				warehouseCapacity(stat, capMin, suppName);
				break;
			}

			System.out.println("1: Connect to DB");
			System.out.println("2: Initiate table 'Warehouse'");
			System.out.println("3: Take a new 'Warehouse' entry");
			System.out.println("4: Collect 'Warehouse' information");
			System.out.println("5: Close DB connection");
						
			System.out.print("Enter choice: ");
			scanIn = mainScan.nextInt();
			mainScan.nextLine();
		}
		
		
		closeConn(conn);
		System.out.println("Exiting.");
	
	}
	
}
