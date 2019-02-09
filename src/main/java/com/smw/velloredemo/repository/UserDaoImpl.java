package com.smw.velloredemo.repository;


import com.smw.velloredemo.Pojo.User;
import com.smw.velloredemo.Pojo.vehiclereportpojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UserDaoImpl {

    private final String INSERT_SQL = "INSERT INTO USERS(name,address,email) values(?,?,?)";
    private final String FETCH_SQL = "select record_id, name, address, email from users";
    private final String FETCH_SQL_BY_ID = "select * from users where record_id = ?";

    private final String FETCH_RECORD = "select * from vehiclereport where Date(intime) BETWEEN ?  AND ? ";

    private final String FETCH_VEHICLE_DATES = "select * from vehiclereport where vehicleno=?  And  Date(intime)  BETWEEN ?  AND ?";


    private final String FETCH_RFID_DATE_UPDATE = "SELECT vehicleid from swm.vehiclereport  where userid=? &&  UNIX_TIMESTAMP(intime) = UNIX_TIMESTAMP(outtime) && DATE(intime) =CURDATE() ORDER BY vehicleid Desc LIMIT 1";

    private final String CHECK_INTERVAL_1HR = "select round(timestampdiff(second,UNIX_TIMESTAMP(intime), UNIX_TIMESTAMP(outtime))/3600)as hours from swm.vehiclereport ";






    private final String FETCH_RFID_UPDATE_TIMESTAMP = "update swm.vehiclereport  set outtime=CURRENT_TIMESTAMP() where vehicleid=? &&  userid=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User create(final User user) {
        try {

            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getAddress());
                    ps.setString(3, user.getEmail());
                    return ps;
                }
            }, holder);

            int newUserId = holder.getKey().intValue();
            user.setId(newUserId);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List findAll() {
        try {

            return jdbcTemplate.query(FETCH_SQL, new UserMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findUserById(int id) {
        try {
            return (User) jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[]{id}, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List responseEntity(String fromdate, String todate) {
        try {
            return jdbcTemplate.query(FETCH_RECORD, new Object[]{fromdate, todate}, new VehicleMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List responseEntitywithVehicle(String fromdate, String todate, String vehicleno) {
        try {
            return jdbcTemplate.query(FETCH_VEHICLE_DATES, new Object[]{vehicleno, fromdate, todate}, new VehicleMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public String rfidcheckAlreadyLoggedornotVerify(String userid) {





        try {


//           String check= jdbcTemplate.queryForObject(CHECK_INTERVAL_1HR, new Object[]{userid}, String.class);
//            return check;
          return jdbcTemplate.queryForObject(FETCH_RFID_DATE_UPDATE, new Object[]{userid}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public String rfidupdate(long vehicleno, String userid) {
        try {
            //jdbcTemplate.update(FETCH_RFID_UPDATE_TIMESTAMP, new Object[]{vehicleno,userid}, Object.class);

            jdbcTemplate.update(FETCH_RFID_UPDATE_TIMESTAMP, vehicleno, userid);
            return "success";
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}

class UserMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("record_id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}


class VehicleMapper implements RowMapper {

    @Override
    public vehiclereportpojo mapRow(ResultSet rs, int rowNum) throws SQLException {
        vehiclereportpojo vehiclereportpojo = new vehiclereportpojo();
        vehiclereportpojo.
                setVehicleid(rs.getString("vehicleid"))
                .setVehiclename(rs.getString("vehiclename"))
                .setVehiclecapacity(rs.getString("vehiclecapacity"))
                .setVehicleinformation(rs.getString("vehicleinformation"))
                .setUserid(rs.getString("userid"))
                .setMobileno(rs.getString("mobileno"))
                .setIntime(rs.getString("intime").replace(' ', 'T'))
                .setOuttime(rs.getString("outtime").replace(' ', 'T'))
                .setUpdateby(rs.getString("updateby"))
                .setRfid(rs.getString("rfid"))
                .setTotalquantity(rs.getString("totalquantity"))
                .setWet(rs.getString("wet"))
                .setDry(rs.getString("dry"))
                .setCreatedon(rs.getString("createdon"))
                .setEntrytype(rs.getString("entrytype"))
                .setVehicleno(rs.getString("vehicleno"));
        return vehiclereportpojo;

    }


}
