package LibraryManagementSystem;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class userMenu extends javax.swing.JFrame {


    OraclePreparedStatement pst=null;
    OracleResultSet rs=null;
    
		private static int member_id;
		    public userMenu(int member_id) {
		        this.member_id=member_id;
		    	initComponents();     
		    }
		    public userMenu() {
		    	initComponents();     
		    }


		    @SuppressWarnings("unchecked")
		    private void initComponents() {

		        jPanel1 = new javax.swing.JPanel();
		        jLabel1 = new javax.swing.JLabel();
		        jButton1 = new javax.swing.JButton();
		        jButton2 = new javax.swing.JButton();
		        jButton3 = new javax.swing.JButton();
		        textField1 = new java.awt.TextField();
		        textField2 = new java.awt.TextField();
		        textField3 = new java.awt.TextField();
		        jButton4 = new javax.swing.JButton();

		        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

		        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		        jLabel1.setText("Choose your action:");

		        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		        jButton1.setText("See my profile");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

		        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		        jButton2.setText("See books by genre");
		        jButton2.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton2ActionPerformed(evt);
		            }
		        });

		        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		        jButton3.setText("See books by author");
		        jButton3.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton3ActionPerformed(evt);
		            }
		        });
		        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		        jButton4.setText("Search by title: ");
		        jButton4.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton4ActionPerformed(evt);
		            }
		        });

		        textField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
		        textField1.setText("Search genre...");

		        textField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
		        textField2.setText("Author's Last Name...");
		        
		        textField3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
		        textField3.setText("Title...");

		        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		        jPanel1.setLayout(jPanel1Layout);
		        jPanel1Layout.setHorizontalGroup(
		            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		                .addContainerGap(44, Short.MAX_VALUE)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
		                            .addComponent(jLabel1))
		                        .addGap(118, 118, 118))
		                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
		                            .addGroup(jPanel1Layout.createSequentialGroup()
		                                .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(jButton3))
		                            .addGroup(jPanel1Layout.createSequentialGroup()
		                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                        .addGap(35, 35, 35))
		                    .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(35, 35, 35))
		);
		        jPanel1Layout.setVerticalGroup(
		            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGap(28, 28, 28)
		                .addComponent(jLabel1)
		                .addGap(30, 30, 30)
		                .addComponent(jButton1)
		                .addGap(37, 37, 37)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addGap(38, 38, 38)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			                    .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			                .addGap(38, 38, 38)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addContainerGap(52, Short.MAX_VALUE))
		        );

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        );

		        pack();
		    }// </editor-fold>//GEN-END:initComponents

		    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		    	new userInfo(member_id).setVisible(true);
		    	setVisible(false);
		    }
		    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {		                 
		                JFrame f = new JFrame("Books Available"); 
		                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                Connection con=null;
		        		con= OracleCon.connectOracle();
		               
		                try {
		                	String sql="select title,genre,publication_date,DEREF(author).name AS Author_name,DEREF(author).surname AS Author_Surname from books_table where genre=?"; //select all books 
		                	
		                	pst= (OraclePreparedStatement) con.prepareStatement(sql);
		        			pst.setString(1, textField1.getText());	
		        			rs=(OracleResultSet) pst.executeQuery();
		                    JTable book_list= new JTable(); //view data in table format
		                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
		                    //mention scroll bar
		                    JScrollPane scrollPane = new JScrollPane(book_list); 
		     
		                    f.add(scrollPane); //add scrollpane
		                    f.setSize(800, 400); //set size for frame
		                    f.setVisible(true);
		                    f.setLocationRelativeTo(null);
		                    con.close();   
		                	pst.close();
			                 
		                } catch (SQLException e1) {
		                     JOptionPane.showMessageDialog(null, e1);
		                }               
		                 
		        }

		    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		    	   JFrame f = new JFrame("Books Available"); 
	                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                Connection con=null;
	        		con= OracleCon.connectOracle();
	               
	                try {
	                	String sql="select title,genre,publication_date,DEREF(author).name AS Author_name,DEREF(author).surname AS Author_Surname  from books_table where DEREF(author).surname=?"; //select all books 
	                	pst= (OraclePreparedStatement) con.prepareStatement(sql);
	        			pst.setString(1, textField2.getText());	
	        			rs=(OracleResultSet) pst.executeQuery();
	                    JTable book_list= new JTable(); //view data in table format
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                    //mention scroll bar
	                    JScrollPane scrollPane = new JScrollPane(book_list); 
	     
	                    f.add(scrollPane); //add scrollpane
	                    f.setSize(800, 400); //set size for frame
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                    con.close();   
	                	pst.close();
		             
	                } catch (SQLException e1) {
	                     JOptionPane.showMessageDialog(null, e1);
	                }               
	                 
		    }
		    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {		                 
		    	   JFrame f = new JFrame("Books Available"); 
	                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                Connection con=null;
	        		con= OracleCon.connectOracle();
	               
	                try {
	                	String sql="select title,genre,publication_date,DEREF(author).name AS Author_name,DEREF(author).surname AS Author_Surname  from books_table where title=?"; //select all books 
	                	
	                	pst= (OraclePreparedStatement) con.prepareStatement(sql);
	        			pst.setString(1, textField3.getText());	
	        			rs=(OracleResultSet) pst.executeQuery();
	                    JTable book_list= new JTable(); //view data in table format
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                    //mention scroll bar
	                    JScrollPane scrollPane = new JScrollPane(book_list); 
	     
	                    f.add(scrollPane); //add scrollpane
	                    f.setSize(800, 400); //set size for frame
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                    con.close();   
	                	pst.close();
		                 
	                } catch (SQLException e1) {
	                     JOptionPane.showMessageDialog(null, e1);
	                } 
	               
                 
        }
		    public static void main(String args[]) {
	
		        /* Create and display the form */
		        java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new userMenu(member_id).setVisible(true);
		            }
		        });
		    }

		    // Variables declaration - do not modify//GEN-BEGIN:variables
		    private javax.swing.JButton jButton1;
		    private javax.swing.JButton jButton2;
		    private javax.swing.JButton jButton3;
		    private javax.swing.JButton jButton4;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JPanel jPanel1;
		    private java.awt.TextField textField1;
		    private java.awt.TextField textField2;
		    private java.awt.TextField textField3;
		    
		    // End of variables declaration//GEN-END:variables
		}
