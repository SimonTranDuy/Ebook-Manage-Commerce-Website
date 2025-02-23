package com.DAO;

import java.sql.Connection;
import com.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
    private Connection conn;

    public UserDAOImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean userRegister(User us) {
        boolean f = false;
        PreparedStatement ps = null;
        try {
            String sql = "insert into user(name,email,phno,password) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno());
            ps.setString(4, us.getPassword());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f;
    }

    public User login(String email, String password) {
        User us = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from user where email=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                us = new User();
                us.setId(rs.getInt("id"));
                us.setName(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setPhno(rs.getString("phno"));
                us.setPassword(rs.getString("password"));
                us.setAddress(rs.getString("address"));
                us.setLandmark(rs.getString("landmark"));
                us.setCity(rs.getString("city"));
                us.setState(rs.getString("state"));
                us.setPincode(rs.getString("pincode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return us;
    }

    public boolean checkPassword(int id, String ps) {
        boolean f = false;
        try {
            String sql = "select * from user where id=? and password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, ps);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean updateProfile(User us) {
        boolean f = false;
        PreparedStatement ps = null;
        try {
            String sql = "update user set name=?,email=?,phno=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno());
            ps.setInt(4, us.getId());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean checkUser(String em) {
        boolean f = true;
        try {
            String sql = "select * from user where email=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, em);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                f = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}