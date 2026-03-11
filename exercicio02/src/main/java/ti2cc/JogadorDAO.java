package ti2cc;

import java.sql.*;

public class JogadorDAO {
    String url = "jdbc:postgresql://localhost:5432/campeonato";
    String usuario = "ti2cc";
    String senha = "ti@cc";

    public void inserir(int num, String nome, String time, String pos) {
        try {
            Connection c = DriverManager.getConnection(url, usuario, senha);
            
            String sql = "INSERT INTO campeonato (\"Numero\", \"Nome\", \"Time\", \"Posicao\") VALUES (?, ?, ?, ?)";
            PreparedStatement st = c.prepareStatement(sql);
            
            st.setInt(1, num);    
            st.setString(2, nome);
            st.setString(3, time);
            st.setString(4, pos);
            
            st.executeUpdate();
            st.close();
            c.close();
            System.out.println("Salvo no campeonato!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            Connection c = DriverManager.getConnection(url, usuario, senha);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM campeonato");

            while (rs.next()) {
                System.out.println("Nº: " + rs.getInt("Numero") + 
                                   " | Nome: " + rs.getString("Nome") +
                                   " | Time: " + rs.getString("Time") +
                                   " | Pos: " + rs.getString("Posicao"));
            }
            rs.close();
            st.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    public void excluir(int num) {
        try {
            Connection c = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement st = c.prepareStatement("DELETE FROM campeonato WHERE \"Numero\" = ?");
            st.setInt(1, num);
            st.executeUpdate();
            st.close();
            c.close();
            System.out.println("Excluído do campeonato!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}