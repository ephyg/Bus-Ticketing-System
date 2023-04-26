package com.astu.bustransportsystem.Models;

import com.astu.bustransportsystem.Exceptions.AuthenticationException;
import com.astu.bustransportsystem.Utilities.DBController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public int SSN;
    public String FirstName;
    public String LastName;
    public String PhoneNumber;
    public Roles Role;
    public String BankAccountNo;

    public  User() {}

    public User(int SSN, String firstName, String lastName, String phoneNumber, Roles role, String bankAccountNo) {
        this.SSN = SSN;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Role = role;
        BankAccountNo = bankAccountNo;
    }


    public static User login(int ssn, String password) throws  AuthenticationException{
        try {
            String hashed_pass = DBController.hash_md5(password);

            PreparedStatement sql = DBController.getPreparedStmt("SELECT * FROM User WHERE ssn=? AND password=?");
            sql.setInt(1, ssn);
            sql.setString(2, hashed_pass);

            ResultSet result  = sql.executeQuery();

            if (result.next()) {
                User current = new User();
                current.SSN = result.getInt("SSN");
                current.FirstName = result.getString("FirstName");
                current.LastName = result.getString("LastName");
                current.PhoneNumber = result.getString("PhoneNumber");
                current.BankAccountNo = result.getString("BankAccountNo");
                current.Role = Roles.valueOf(result.getString("Role"));
                return  current;
            }else {
                throw new AuthenticationException();
            }

        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new User();
    }
}
