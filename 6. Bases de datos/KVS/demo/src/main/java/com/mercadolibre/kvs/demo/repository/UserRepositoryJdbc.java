package com.mercadolibre.kvs.demo.repository;

import com.mercadolibre.kvs.demo.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryJdbc {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryJdbc(@Qualifier("my-container-ds") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findUsersByCountry(String country) {
        String sql = "SELECT id, nombre, apellido, genero, fecha_nacimiento FROM users WHERE pais = ?";
        return jdbcTemplate.query(sql, new Object[]{country}, new UserRowMapper());
    }

    // RowMapper que mapea cada fila del resultado a un objeto User
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setNombre(rs.getString("nombre"));
            user.setApellido(rs.getString("apellido"));
            user.setGenero(rs.getString("genero"));
            user.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            return user;
        }
    }
}


