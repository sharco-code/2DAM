import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;


public class TablaBarras extends JFrame {
    
	TablaBarras(String Title) {
        
        JFreeChart pieChart = ChartFactory.createBarChart(Title, "", "", data());
         
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset data() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	dataset.addValue( 15 , "lluvia" , "2000" );
        dataset.addValue( 50 , "lluvia" , "2005" );
        dataset.addValue( 60 , "lluvia" ,  "2010" );
        return dataset;
    }
    
    
    public static void main(String[] args) {
    	TablaBarras main = new TablaBarras("Datos");
        main.pack();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}