package sisBib.testes;

import sisBib.db.PostgreSQL;

public class TestaDB {

	public static void main(String[] args) {
		PostgreSQL db = new PostgreSQL();

		String sql = "";
		
		db.abrirConexao("sisbib", "12345");
		
		sql = "SELECT codigo, curso "
			+ "FROM cursos "
			+ "WHERE 1 = ? "
			+ "ORDER BY curso ";
		//sql = "SELECT 333 as codigo, 'Abrantes' as nome";
		
		try {
			db.prepararQuery(sql);
			db.usarQuery().setInt(1, 1);
			db.executarQuery();
			int codigo;
			String curso;
			while (db.resultadosDaQuery().next()) {
				codigo = Integer.parseInt(db.resultadosDaQuery().getString("codigo"));
				curso = db.resultadosDaQuery().getString("curso");
				System.out.printf("%3d\t" + curso + "\n", codigo);
			}
			db.terminaQuery();
		} catch (Exception e) {
			e.toString();
		}

//		if (db.conexaoEstaAtiva()) {
//			System.out.println("ativa");
//		} else {
//			System.out.println("fechada");
//		}
		
		
		System.out.println("\n");
		
		sql = "SELECT a.matricula, "
			+ "       a.nome, "
		    + "       a.data, "
			+ "       c.curso "
			+ "FROM sisbib.alunos a "
			+ "INNER JOIN sisbib.cursos c ON (a.codigo_curso = c.codigo) "
			+ "ORDER BY a.nome ";
			//sql = "SELECT 333 as codigo, 'Abrantes' as nome";
			
		System.out.println("agora");
			try {
				db.prepararQuery(sql);
				//db.usarQuery().setInt(1, 1);
				//db.usarQuery().setInt(2, 61);
				//db.usarQuery().setInt(3, 63);
				//db.usarQuery().setInt(4, 2);
				db.executarQuery();
				//query = db.usarConexao().prepareStatement(sql);
				//query.setInt(1, 2);
				//query.set
				//ResultSet resultados = query.executeQuery();
				//while (resultados.next()) {
				int matricula;
				String nome, data, curso;
				while (db.resultadosDaQuery().next()) {
					matricula = Integer.parseInt(db.resultadosDaQuery().getString("matricula"));
					nome = db.resultadosDaQuery().getString("nome");
					data = db.resultadosDaQuery().getString("data");
					curso = db.resultadosDaQuery().getString("curso");
					System.out.printf("%3d\t%-30s\t%-30s\t%-10s\n", matricula, nome, curso, data);
				}
				db.terminaQuery();
			} catch (Exception e) {
				e.toString();
			}
	
			db.fecharConexao();
	}

}
