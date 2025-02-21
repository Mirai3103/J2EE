package com.bkap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bkap.entities.Flower;

public class FlowerImpl implements FlowerDao {
    private Connection con = null;

    public FlowerImpl() {
        this.con = DatabaseUtil.getConnect();
    }

    private Flower parseResultSet(ResultSet rs) throws SQLException {
        return new Flower(
            rs.getString("flowerid"),
            rs.getString("flowername"),
            rs.getString("unit"),
            rs.getFloat("price"), // Changed from float to double for SQLite REAL
            rs.getFloat("priceold"), // Changed from float to double
            rs.getString("brief"),
            rs.getString("description"),
            rs.getString("picture"),
            // SQLite stores dates as TEXT, need to parse
            rs.getString("createdate") != null ? Date.valueOf(rs.getString("createdate")) : null,
            // SQLite stores booleans as INTEGER (0/1)
            rs.getInt("active") == 1
        );
    }

    @Override
    public List<Flower> getAll() {
        List<Flower> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Flowers");
            while (rs.next()) {
                data.add(parseResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Flower getById(String flowerid) {
        Flower flower = null;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Flowers WHERE flowerid = ?");
            pst.setString(1, flowerid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                flower = parseResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flower;
    }

    @Override
    public boolean insert(Flower f) {
        try {
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO Flowers VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            pst.setString(1, f.getFlowerId());
            pst.setString(2, f.getFlowerName());
            pst.setString(3, f.getUnit());
            pst.setDouble(4, f.getPrice()); // Changed from setFloat to setDouble
            pst.setDouble(5, f.getPriceOld());
            pst.setString(6, f.getBrief());
            pst.setString(7, f.getDescription());
            pst.setString(8, f.getPicture());
            // Handle date for SQLite
            pst.setString(9, f.getCreateDate() != null ? f.getCreateDate().toString() : null);
            // Handle boolean for SQLite
            pst.setInt(10, f.isActive() ? 1 : 0);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Flower f) {
        try {
            PreparedStatement pst = con.prepareStatement(
                "UPDATE Flowers SET flowername = ?, unit = ?, price = ?, priceold = ?, " +
                "brief = ?, description = ?, picture = ?, createdate = ?, active = ? " +
                "WHERE flowerid = ?"
            );
            pst.setString(10, f.getFlowerId());
            pst.setString(1, f.getFlowerName());
            pst.setString(2, f.getUnit());
            pst.setDouble(3, f.getPrice()); // Changed from setFloat to setDouble
            pst.setDouble(4, f.getPriceOld());
            pst.setString(5, f.getBrief());
            pst.setString(6, f.getDescription());
            pst.setString(7, f.getPicture());
            // Handle date for SQLite
            pst.setString(8, f.getCreateDate() != null ? f.getCreateDate().toString() : null);
            // Handle boolean for SQLite
            pst.setInt(9, f.isActive() ? 1 : 0);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String flowerid) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Flowers WHERE flowerid = ?");
            pst.setString(1, flowerid);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}