package sisBib.testes;

import sisBib.util.Config;

public class TestaINI {

	public static void main(String[] args) {
		Config config = new Config();
		
		System.out.println(config.getDbLibPath());
		System.out.println(config.getDbDriver());
		System.out.println(config.getDbUrl());
		System.out.println(config.getDbLingua());
		System.out.println(config.getDbPais());

	}

}
