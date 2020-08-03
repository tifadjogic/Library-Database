package LibraryManagementSystem;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.Types;
	import javax.swing.JOptionPane;
	import javax.swing.JTextArea;
	import oracle.jdbc.OraclePreparedStatement;
	import oracle.jdbc.OracleResultSet;
	public class librarianInfo extends javax.swing.JFrame {

		private static int member_id;
		
	    public librarianInfo(int member_id) {
	    	this.member_id=member_id;
	        initComponents();
	    }
	        
	    
	    public librarianInfo(){
	        initComponents();
	    }
	        
	    private void initComponents() {
	    	   OraclePreparedStatement pst=null;
	    	    OracleResultSet rs=null;

	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jTextArea1 = new javax.swing.JTextArea();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
	        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
	        jLabel1.setText("User Information");

	        jButton1.setText("Back to menu");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
	        
	        Connection con=null;
			con= OracleCon.connectOracle();
			try {
				String sql="select * from member_table where member_id=?";
				pst= (OraclePreparedStatement) con.prepareStatement(sql);
				pst.setInt(1, member_id);
				rs=(OracleResultSet) pst.executeQuery();
				CallableStatement cs = con.prepareCall("{?=call library_package.showInfo(?)}");
				cs.registerOutParameter(1,Types.VARCHAR); 
						cs.setInt(2, member_id);
						cs.executeUpdate();
						String s=cs.getString(1);
						jTextArea1.setText(s);	
						 con.close();   
		                 pst.close();         
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}  
	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel1)
	                .addGap(130, 130, 130)
	                .addComponent(jButton1)
	                .addGap(104, 104, 104))
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(46, 46, 46)
	                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(60, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(27, 27, 27)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jButton1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(18, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 1, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        new adminMenu(member_id).setVisible(true);
	    	setVisible(false);
	    }
	    public static void main(String args[]) {
	       
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new userInfo().setVisible(true);
	            }
	        });
	    }

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private JTextArea jTextArea1;
	    private javax.swing.JPanel jPanel1;
	    // End of variables declaration//GEN-END:variables
	}
