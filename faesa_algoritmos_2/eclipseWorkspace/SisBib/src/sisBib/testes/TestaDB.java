package sisBib.testes;

import sisBib.db.PostgreSQL;

public class TestaDB {

	public static void main(String[] args) {
		PostgreSQL db = new PostgreSQL();

		String sql = "";
		
		db.abrirConexao("vdiesel", "12345");
		
		sql = "SELECT * "
			+ "FROM filiais "
			+ "WHERE 1 = ? "
			+ "ORDER BY ? ";
		sql = "SELECT * FROM filiais WHERE 1 = ? ORDER BY id ";
		
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
			int id;
			String filial;
			while (db.resultadosDaQuery().next()) {
				id = Integer.parseInt(db.resultadosDaQuery().getString("id"));
				filial = db.resultadosDaQuery().getString("filial");
				System.out.printf("%3d\t" + filial + "\n", id);
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
