using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Access = Microsoft.Office.Interop.Access;
using Excel = Microsoft.Office.Interop.Excel;
using Word = Microsoft.Office.Interop.Word;
using PowerPoint = Microsoft.Office.Interop.PowerPoint;
using Microsoft.Office.Core;
using System.Reflection;

using Microsoft.Office.Interop;
using System.Data.OleDb;
using System.Configuration;

namespace CallMSAccessMacros
{
    public partial class Form1 : System.Windows.Forms.Form
    {
        DataTable dtReports;
        public Form1()
        {
            InitializeComponent();
            dtReports = new DataTable();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Object for missing (or optional) arguments.
            object oMissing = System.Reflection.Missing.Value;

            #region Run Macro as selected

            string sMacro = dtReports.Rows[comboBox1.SelectedIndex]["Argument"] != null ? (dtReports.Rows[comboBox1.SelectedIndex]["Argument"].ToString()) : "";
            if (sMacro.Equals(""))
            {
                MessageBox.Show("No macro exists for the selected report");
                comboBox1.Focus();
                return;
            }
            string sArgument1 = "", sArgument2 = "";            

            Access.Application oAccess= new Access.Application();
            oAccess.Visible = true;
            string sDbFile = ConfigurationSettings.AppSettings["filePath"].ToString();
            oAccess.OpenCurrentDatabase(sDbFile, false, "");

            sArgument1 = dtReports.Rows[comboBox1.SelectedIndex]["Argument1"] != null?dtReports.Rows[comboBox1.SelectedIndex]["Argument1"].ToString():"";
            sArgument2 = dtReports.Rows[comboBox1.SelectedIndex]["Argument2"] != null?dtReports.Rows[comboBox1.SelectedIndex]["Argument2"].ToString():"";

            // Run the macros.
            if (!((sArgument1.Equals("")||(sArgument2.Equals("")))))
            {
                RunMacro(oAccess, new Object[] { sMacro, sArgument1, sArgument2 });
            }
            else if(!sArgument1.Equals(""))
            {
                RunMacro(oAccess, new Object[] { sMacro, sArgument1 });
            }
            else if (!sArgument2.Equals(""))
            {
                RunMacro(oAccess, new Object[] { sMacro, sArgument2 });
            }
            else
            {
                RunMacro(oAccess, new Object[] { sMacro });
            }

            // Quit Access and clean up.
            oAccess.DoCmd.Quit(Access.AcQuitOption.acQuitSaveNone);
            System.Runtime.InteropServices.Marshal.ReleaseComObject(oAccess);
            oAccess = null;
            
            #endregion

            #region switch
            ////Switch based on the user selection.
            //switch (comboBox1.SelectedIndex)
            //{
            //    case 0:
            //        // Create an instance of Microsoft Access, make it visible,
            //        // and open Db1.mdb.
            //        //Microsoft.Office.Interop.Access.Application oAccess = new Microsoft.Office.Interop.Access.Application();
            //        //oAccess.Visible = true;
            //        oAccess.OpenCurrentDatabase("d:\\testdb.mdb", false, "");

            //        // Run the macros.
            //        RunMacro(oAccess, new Object[] { "DoKbTest" });
            //        RunMacro(oAccess, new Object[]{"DoKbTestWithParameter",
            //                "Hello from C# Client."});

            //        // Quit Access and clean up.
            //        oAccess.DoCmd.Quit(Access.AcQuitOption.acQuitSaveNone);
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oAccess);
            //        oAccess = null;

            //        break;

            //    case 1:
            //        // Create an instance of Microsoft Excel, make it visible,
            //        // and open Book1.xls.
            //        Excel.ApplicationClass oExcel = new Excel.ApplicationClass();
            //        oExcel.Visible = true;
            //        Excel.Workbooks oBooks = oExcel.Workbooks;
            //        Excel._Workbook oBook = null;
            //        oBook = oBooks.Open("c:\\book1.xls", oMissing, oMissing,
            //            oMissing, oMissing, oMissing, oMissing, oMissing, oMissing,
            //            oMissing, oMissing, oMissing, oMissing, oMissing, oMissing);

            //        // Run the macros.
            //        RunMacro(oExcel, new Object[] { "DoKbTest" });
            //        RunMacro(oExcel, new Object[]{"DoKbTestWithParameter",
            //               "Hello from C# Client."});

            //        // Quit Excel and clean up.
            //        oBook.Close(false, oMissing, oMissing);
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oBook);
            //        oBook = null;
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oBooks);
            //        oBooks = null;
            //        oExcel.Quit();
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oExcel);
            //        oExcel = null;

            //        break;

            //    case 2:

            //        // Create an instance of PowerPoint, make it visible,
            //        // and open Pres1.ppt.
            //        PowerPoint.ApplicationClass oPP = new PowerPoint.ApplicationClass();
            //        oPP.Visible = MsoTriState.msoTrue;
            //        PowerPoint.Presentations oPresSet = oPP.Presentations;
            //        PowerPoint._Presentation oPres = oPresSet.Open("c:\\pres1.ppt",
            //            MsoTriState.msoFalse, MsoTriState.msoFalse,
            //            MsoTriState.msoTrue);

            //        // Run the macros.
            //        RunMacro(oPP, new Object[] { "'pres1.ppt'!DoKbTest" });
            //        RunMacro(oPP, new Object[]{"'pres1.ppt'!DoKbTestWithParameter",
            //               "Hello from C# Client."});

            //        // Quit PowerPoint and clean up.
            //        oPres.Close();
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oPres);
            //        oPres = null;
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oPresSet);
            //        oPresSet = null;
            //        oPP.Quit();
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oPP);
            //        oPP = null;

            //        break;

            //    case 3:

            //        // Create an instance of Word, make it visible,
            //        // and open Doc1.doc.
            //        Word.ApplicationClass oWord = new Word.ApplicationClass();
            //        oWord.Visible = true;
            //        Word.Documents oDocs = oWord.Documents;
            //        object oFile = "c:\\doc1.doc";

            //        // If the Microsoft Word 10.0 Object Library is referenced
            //        // use the following code.
            //        Word._Document oDoc = oDocs.Open(ref oFile, ref oMissing,
            //            ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //            ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //            ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //            ref oMissing);

            //        // If the Microsoft Word 11.0 Object Library is referenced comment
            //        // the previous line of code and uncomment the following code.
            //        //Word._Document oDoc = oDocs.Open(ref oFile, ref oMissing,
            //        //ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //        //ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //        //ref oMissing, ref oMissing, ref oMissing, ref oMissing,
            //        //ref oMissing, ref oMissing);

            //        // Run the macros.
            //        RunMacro(oWord, new Object[] { "DoKbTest" });
            //        RunMacro(oWord, new Object[]{"DoKbTestWithParameter",
            //               "Hello from C# Client."});

            //        // Quit Word and clean up.
            //        oDoc.Close(ref oMissing, ref oMissing, ref oMissing);
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oDoc);
            //        oDoc = null;
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oDocs);
            //        oDocs = null;
            //        oWord.Quit(ref oMissing, ref oMissing, ref oMissing);
            //        System.Runtime.InteropServices.Marshal.ReleaseComObject(oWord);
            //        oWord = null;

            //        break;

            //}
            #endregion

            GC.Collect();   //Garbage collection.
        }

        private void RunMacro(object oApp, object[] oRunArgs)
        {
            oApp.GetType().InvokeMember("Run",
                System.Reflection.BindingFlags.Default |
                System.Reflection.BindingFlags.InvokeMethod,
                null, oApp, oRunArgs);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            string connectionString = ConfigurationSettings.AppSettings["connectionString"].ToString();

            using(OleDbConnection conn = new OleDbConnection(connectionString))
            {
                string sQuery = ConfigurationSettings.AppSettings["query"].ToString();
                var command = new OleDbCommand(sQuery, conn);
                OleDbDataAdapter da = new OleDbDataAdapter(command);
                da.Fill(dtReports);
            }
            comboBox1.DataSource = dtReports;
            comboBox1.DisplayMember = "ItemText";
            comboBox1.ValueMember = "ItemNumber";
            //comboBox1.Items.Insert(0, "--Select--");

            //comboBox1.Items.AddRange(new object[] { "Access", "Excel", "PowerPoint", "Word" });
            comboBox1.SelectedIndex = 0;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
