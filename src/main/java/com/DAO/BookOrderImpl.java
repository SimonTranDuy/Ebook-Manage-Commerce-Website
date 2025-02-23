package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Book_Order;

import java.util.ArrayList;
import java.util.List;

public class BookOrderImpl implements BookOrderDAO {

    private Connection conn;

    public BookOrderImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean saveOrder(List<Book_Order> blist) {
        boolean f = false;
        try {
            String sql = "insert into book_order(order_id, user_name, email, address, phno, book_name, author, price, payment) values(?,?,?,?,?,?,?,?,?)";
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (Book_Order b : blist) {
                ps.setString(1, b.getOrderId());
                ps.setString(2, b.getUserName());
                ps.setString(3, b.getEmail());
                ps.setString(4, b.getFulladd());
                ps.setString(5, b.getPhno());
                ps.setString(6, b.getBookName());
                ps.setString(7, b.getAuthor());
                ps.setString(8, b.getPrice());
                ps.setString(9, b.getPaymentType());
                ps.addBatch();
            }

            ps.executeBatch();
            conn.commit();
            f = true;
            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Book_Order> getBook(String email) {
        List<Book_Order> list = new ArrayList<Book_Order>();
        Book_Order o = null;

        try {
            String sql = "select * from book_order where email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                o = new Book_Order();
                o.setOrderId(rs.getString("order_id"));
                o.setUserName(rs.getString("user_name"));
                o.setEmail(rs.getString("email"));
                o.setFulladd(rs.getString("address"));
                o.setPhno(rs.getString("phno"));
                o.setBookName(rs.getString("book_name"));
                o.setAuthor(rs.getString("author"));
                o.setPrice(rs.getString("price"));
                o.setPaymentType(rs.getString("payment"));
                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Book_Order> getAllOrder() {
        List<Book_Order> list = new ArrayList<Book_Order>();
        Book_Order o = null;

        try {
            String sql = "select * from book_order";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                o = new Book_Order();
                o.setOrderId(rs.getString("order_id"));
                o.setUserName(rs.getString("user_name"));
                o.setEmail(rs.getString("email"));
                o.setFulladd(rs.getString("address"));
                o.setPhno(rs.getString("phno"));
                o.setBookName(rs.getString("book_name"));
                o.setAuthor(rs.getString("author"));
                o.setPrice(rs.getString("price"));
                o.setPaymentType(rs.getString("payment"));
                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
