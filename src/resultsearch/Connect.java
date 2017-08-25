/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resultsearch;
import java.sql.*;


/**
 *
 * @author sherif
 */
public class Connect {


      private static String [][] ResultArray ;
      private static int NumOfCols ;
      private static int NumOfRows ;
      public static Connection con;
      
      
      public static boolean testConnection() throws ClassNotFoundException, SQLException
      {
          Class.forName("com.mysql.jdbc.Driver");
           // String connectionUrl = "jdbc:mysql://198.71.227.83:3306/mbanoun_?" +
           //                        "user=root&password=root1234&useUnicode=yes&characterEncoding=UTF-8";
             String connectionUrl = "jdbc:mysql://212.24.107.233:3306/admin_mu?" +
                                   "user=admin_mu&password=asas123&useUnicode=yes&characterEncoding=UTF-8";
             con = DriverManager.getConnection(connectionUrl);
             return con.isValid(5);
      }
      
      public static String[][] Conn(String Query,boolean Insert) {
        // TODO code application logic here
         // String Result="";
      try
       {
                Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://212.24.107.233:3306/admin_mu?" +
                                   "user=admin_mu&password=asas123&useUnicode=yes&characterEncoding=UTF-8";
             con = DriverManager.getConnection(connectionUrl);


            Statement stmt = null;

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = null;

            if(Insert)
            {
            stmt = con.createStatement();
            int rowsEffected = stmt.executeUpdate(Query);
            System.out.println(rowsEffected + " rows effected");
            ResultArray = new String [1][1];
            ResultArray[0][0]=String.valueOf(rowsEffected);
            return ResultArray;
            }
            else
            {
             stmt = con.createStatement();
             rs = stmt.executeQuery(Query);
             ResultSetMetaData rsmd = rs.getMetaData();
             NumOfCols = rsmd.getColumnCount();
             rs.last();
             NumOfRows = rs.getRow();
             rs.beforeFirst();
             ResultArray = new String [NumOfRows][NumOfCols];

          //   System.out.println(NumOfRows);
          //   System.out.println(NumOfCols);

             while (rs.next())
                    {
                        for(int j = 1 ; j <= NumOfCols ; j++)
                        {
                     //   System.out.println(rs.getString(j));
                        ResultArray [rs.getRow()-1][j-1] = rs.getString(j);
                        }
                    }
            }

       }

       catch (SQLException e)
       {
            System.out.println("SQL Exception: "+ e.toString());
            System.out.println("SQL CAUSED THE PROBLEM :" + Query);
       }

       catch (ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception: "+ cE.toString());

        }

      return ResultArray;
  }

    public static String GetResultArray(int row , int col)
      {
          return ResultArray [row][col];
      }


    public static String[][] GetResultArray()
      {
          return ResultArray;
      }

    public static void SetResultArray(String Arr[][])
      {
          ResultArray = Arr ;
      }

}




