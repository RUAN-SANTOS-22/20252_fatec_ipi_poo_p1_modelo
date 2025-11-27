package br.gov.sp.cps.fatecipiranga.db;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionFactory {
  private static String host = "pg-274380a2-ruanvictor-c151.l.aivencloud.com";
  private static String port = "23212";
  private static String user = "avnadmin";
  private static String password = ""; 
  private static String database = "defaultdb";

  public static Connection getConnection(){
    try{
      String url = String.format(
        "jdbc:postgresql://%s:%s/%s",
        host, port, database
      );
      Connection conexao = DriverManager.getConnection(url, user, password);
      return conexao;
    }
    catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }  

  public static void main(String[] args) {
    Connection conexao = getConnection();
    if(conexao != null){
      System.out.println("Conectou!");
    }
    else{
      System.out.println("Não conectou!");
    }  
  }
}
