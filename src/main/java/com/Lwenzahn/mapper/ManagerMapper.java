package com.Lwenzahn.mapper;

import com.Lwenzahn.pojo.Manager;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ManagerMapper{
    private static Map<String,Manager> managerMap = new HashMap<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/web?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
            Connection connection = DriverManager.getConnection(URL,"root","12345");
            PreparedStatement preparedStatement = connection.prepareStatement("select mgrName,pwd from manager");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                managerMap.put(resultSet.getString("mgrName"),new Manager(resultSet.getString("mgrName"),resultSet.getString("pwd")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Manager login(Manager manager){
        Manager loginManager = managerMap.get(manager.getMgrName());
        if (loginManager != null && manager.getPwd().equals(loginManager.getPwd())){
            return loginManager;
        }else {
            return null;
        }
    }
}
