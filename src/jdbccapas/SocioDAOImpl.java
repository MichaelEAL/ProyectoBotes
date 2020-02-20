/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author lv1013
 */
public class SocioDAOImpl implements SocioDAO {

    private final ConnectionFactory connectionFactory;

    public SocioDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    
    @Override
    public Socio find(int id) throws Exception {
        final String sql = "SELECT id, dni, nombre " +
            "FROM socio WHERE id = ?";
        
        try (Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Socio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("dni"));
                }
                
                return null;
            }
        }
    }

    @Override
    public List<Socio> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Socio socio) throws Exception {
        final String sql = "INSERT INTO socio (dni, nombre) " +
            "VALUES (?, ?)";
        try (
            Connection connection = this.connectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, socio.getDni());
            statement.setString(2, socio.getNombre());
            int id = statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
            socio.setId(id);
        }
    }

    @Override
    public void update(Socio socio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
