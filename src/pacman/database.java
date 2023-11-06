//package pacman;
//import java.sql.*;
//import java.util.*;
//
//public class database {
//  public database() {
//    getConn();
//  }
//
//  public Connection getConn() {
//    try {
//      String driver = "com.mysql.cj.jdbc.Driver";
//      String databaseurl = "jdbc:mysql://db4free.net:3306/pacman";
//
//      String username = "pacplayer";
//      String password = "pacman2522";
//
//      Class.forName(driver);
//      Connection conn = DriverManager.getConnection(databaseurl, username, password);
//
//      return conn;
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//
//    return null;
//  }
//
//  public void insertData(Window win) {
//    String insertDataQuery = "UPDATE player SET score = " + win.getScore() + " WHERE player = 1 AND " +
//            win.getScore() + " > score";
//    try {
//      Statement stm = Objects.requireNonNull(getConn()).createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
////        System.out.println("data statement inserted");
//      stm.execute(insertDataQuery);
////        System.out.println("Data inserted");
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//  public int printData(Window win) {
//    String printDataQuery = "SELECT score FROM player WHERE player = 1";
//    try {
//      Statement stm1 = Objects.requireNonNull(getConn()).createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//      ResultSet rs = stm1.executeQuery(printDataQuery);
//      rs.next();
//      return Integer.parseInt(rs.getString(1));
//
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//  }
//}
