package sisBib.testes;

import java.sql.*;
import sisBib.db.PostgreSQL;

public class TestaJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class.forName("org.postgresql.Driver");
		
//		String url = "jdbc:postgresql://pgsql.endoscopia.vix.br:5432/sisbib?ssl=true&sslfactory=org.postgresql.ssl.LibPQFactory&sslmode=verify-full";
//		Properties props = new Properties();
//		props.setProperty("user","sisbib");
//		props.setProperty("password","12345");
//		props.setProperty("ssl","true");
//		props.setProperty("sslmode", "verify-full");
//		props.setProperty("sslcert","/home/abrantesasf/repositoriosGit/pessoal/CA/endoscopia/sub-ca/certs/sisbib.crt");
//		props.setProperty("sslkey","/home/abrantesasf/repositoriosGit/pessoal/CA/endoscopia/sub-ca/private/sisbib.pk8");
//		props.setProperty("sslrootcert","/home/abrantesasf/repositoriosGit/pessoal/CA/endoscopia/sub-ca/certs/ca-chain.crt");
//			
//		Connection conn = DriverManager.getConnection(url, props);
		
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery("SELECT now()");
//		while (rs.next())
//		{
//		    System.out.println("Coluna 1");
//		    System.out.println(rs.getString(1));
//		}
//		rs.close();
//		st.close();
//		
//		
//		conn.close();
		
		PostgreSQL db = new PostgreSQL();

		String sql = "";
		
		db.abrirConexao("sisbib", "12345");
		
		sql = "SELECT 1 "
			+ "FROM dual "
			+ "WHERE 1 = 1 "
			+ "ORDER BY ? ";
		sql = "SELECT 333 as codigo, 'Abrantes' as nome FROM dual WHERE 1 = 1 ORDER BY 1";
		
		try {
			db.prepararQuery(sql);
			db.usarQuery().setInt(1, 1);
			//db.usarQuery().setInt(2, 61);
			//db.usarQuery().setInt(3, 63);
			//db.usarQuery().setInt(4, 2);
			db.executarQuery();
			//query = db.usarConexao().prepareStatement(sql);
			//query.setInt(1, 2);
			//query.set
			//ResultSet resultados = query.executeQuery();
			//while (resultados.next()) {
			int codigo;
			String nome;
			while (db.resultadosDaQuery().next()) {
				codigo = Integer.parseInt(db.resultadosDaQuery().getString("codigo"));
				nome = db.resultadosDaQuery().getString("nome");
				System.out.printf("%3d\t" + nome + "\n", codigo);
			}
			db.terminaQuery();
			db.fecharConexao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.toString();
		}

		if (db.conexaoEstaAtiva()) {
			System.out.println("ativa");
		} else {
			System.out.println("fechada");
		}

	}

}
