package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    
    public void cadastrarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "INSERT INTO tabela(nome, cidade) VALUES (?, ?)";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNomeFuncionario());
            pstm.setString(2, funcionariodto.getCidadeFuncionario());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro ao cadastrar funcionário");
        }
    }

    
    public ArrayList<FuncionarioDTO> PesquisarFuncionario() {
        String sql = "SELECT * FROM tabela";
        conn = new Conexao().conectaBD();

        ArrayList<FuncionarioDTO> lista = new ArrayList<>();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionariodto = new FuncionarioDTO();
                funcionariodto.setId(rs.getInt("id")); // Certifique-se que "id" é o nome correto da coluna
                funcionariodto.setNomeFuncionario(rs.getString("nome"));
                funcionariodto.setCidadeFuncionario(rs.getString("cidade"));

                lista.add(funcionariodto);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro + " Erro ao pesquisar funcionários");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + " Erro ao fechar recursos");
            }
        }

        return lista;
    }

    
    public boolean alterarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "UPDATE tabela SET nome = ?, cidade = ? WHERE id = ?";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNomeFuncionario());
            pstm.setString(2, funcionariodto.getCidadeFuncionario());
            pstm.setInt(3, funcionariodto.getId());

            pstm.executeUpdate();
            return true; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro ao alterar funcionário");
            return false; 
        } finally {
            try {
                if (pstm != null) pstm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + " Erro ao fechar recursos");
            }
        }
    }

    
    public boolean excluirFuncionario(int idFuncionario) {
        String sql = "DELETE FROM tabela WHERE id = ?";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idFuncionario);

            pstm.executeUpdate();
            return true; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " Erro ao excluir funcionário");
            return false; 
        } finally {
            try {
                if (pstm != null) pstm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e + " Erro ao fechar recursos");
            }
        }
    }

  
}



