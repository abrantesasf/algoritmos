package sisBib.gui;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sisBib.db.PostgreSQL;

public class GuiLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfLogin;
	private JLabel lbLogin;
	private JPasswordField pfSenha;
	private JLabel lbSenha;
	private JButton btLogar;
	private JButton btCancelar;
	private static GuiLogin frame;
	private static PostgreSQL db = new PostgreSQL();
	
	public GuiLogin() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setTitle("Login no SisBib");
		setBounds(0, 0, 250, 250);
		
		setLayout(null);
		
		tfLogin = new JTextField(5);
		lbLogin = new JLabel("Login:");
		lbLogin.setBounds(30, 30, 80, 25);
		tfLogin.setBounds(100, 30, 120, 25);
		add(tfLogin);
		add(lbLogin);
		
		pfSenha = new JPasswordField(5);
		lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(30, 75, 80, 25);
		pfSenha.setBounds(100, 75, 120, 25);
		add(pfSenha);
		add(lbSenha);
		
		btLogar = new JButton("Entrar");
		btLogar.setBounds(20, 120, 100, 25);
		add(btLogar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(125, 120, 100, 25);
		add(btCancelar);
		
	}
	
	private void definirEventos() {
		btLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = String.valueOf(tfLogin.getText());
				String senha = String.valueOf(pfSenha.getPassword());

				db.abrirConexao(usuario, senha);
				
				if (db.conexaoExiste()) {
					JOptionPane.showMessageDialog(getParent(), "Conectado ao banco de dados", "Beleza", 1);
				} else {
					JOptionPane.showMessageDialog(getParent(), "Login ou Senha incorretos!", "Xabu", 0);
				}
			}
		});
		
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.fecharConexao();
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				frame = new GuiLogin();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation((tela.width - frame.getSize().width)/2,
						          (tela.height - frame.getSize().height)/2);
				frame.setVisible(true);
			}
		});
	}

}
