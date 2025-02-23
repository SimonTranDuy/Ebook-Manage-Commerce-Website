package com.DAO;

import com.entity.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class CartDAOImpl implements CartDAO {

    private Connection conn;

    public CartDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean addCart(Cart c) {
        boolean f = false;
        try {
            String sql = "insert into cart (bid, uid, bookName, author, price, total_price) values(?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, c.getBid());
            ps.setInt(2, c.getUserId());
            ps.setString(3, c.getBookName());
            ps.setString(4, c.getAuthor());
            ps.setDouble(5, c.getPrice());
            ps.setDouble(6, c.getTotalPrice());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Cart> getBookByUser(int userId) {
        List<Cart> list = new ArrayList<Cart>();
        Cart c = null;
        double totalPrice = 0.0;
        try {
            String sql = "select * from cart where uid=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cart();
                c.setCid(rs.getInt("cid"));
                c.setBid(rs.getInt("bid"));
                c.setUserId(rs.getInt("uid"));
                c.setBookName(rs.getString("bookName"));
                c.setAuthor(rs.getString("author"));
                c.setPrice(rs.getDouble("price"));

                totalPrice = totalPrice + rs.getDouble("total_price");
                c.setTotalPrice(totalPrice);

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteBook(int bid, int uid, int cid) {
        boolean f = false;
        try {
            String sql = "delete from cart where bid=? and uid=? and cid=?";
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, bid);
            ps.setInt(2, uid);
            ps.setInt(3, cid);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }
}
