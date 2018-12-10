using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TecSQL
{
    public partial class TecSQL : Form
    {
        private const string ConnectionString = "server=localhost; port=3306; user id=javaUser; "+
            "password=cafejava; database=investigadores;";
        private MySqlConnection conexionBD;

        public TecSQL()
        {
            InitializeComponent();
            conexionBD = new MySqlConnection(ConnectionString);
        }

        private void btnEjecutar_Click(object sender, EventArgs e)
        {
            
            string comando = tbComando.Text;
            tbComando.Text = "";

            try
            {
                conexionBD.Open();
                MySqlDataReader lector = null;
                MySqlCommand cmd = new MySqlCommand(comando,conexionBD);

                lector = cmd.ExecuteReader();

                if (lector.FieldCount!=0)
                {
                    tabla.Rows.Clear();
                    tabla.Columns.Clear();

                    for (int i = 0; i < lector.FieldCount; i++)
                    {
                        DataGridViewTextBoxColumn col = new DataGridViewTextBoxColumn();
                        col.HeaderText = lector.GetName(i);
                        tabla.Columns.Add(col);
                    }

                    while (lector.Read())
                    {
                        Object[] array = new object[lector.FieldCount];
                        for (int i = 0; i < array.Length; i++)
                        {
                            array[i] = lector.GetValue(i);
                        }

                        tabla.Rows.Add(array);
                    }
                }
                else
                {
                    MessageBox.Show("Ha sido insertado/actualizado/eliminado");
                }
            }
            catch (MySqlException ex)
            {
                MessageBox.Show(ex.ToString());
            }

            conexionBD.Close();
        }
    }
}
