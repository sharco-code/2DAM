import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;


public class TablaLineas extends JFrame {
    
    TablaLineas(String Title , String horizontal, String vertical) {
        
        JFreeChart lineChart = ChartFactory.createLineChart(Title, horizontal, vertical, data());
         
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset data() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 15 , "lluvia" , "2000" );
        dataset.addValue( 50 , "lluvia" , "2005" );
        dataset.addValue( 60 , "lluvia" ,  "2010" );
        dataset.addValue( 90 , "lluvia" , "2015" );
        dataset.addValue( 60 , "lluvia" , "2019" );
        return dataset;
    }
    
    
    public static void main(String[] args) {
        TablaLineas main = new TablaLineas("Lluvia Alberique", "Meses", "Precipitaciones");
        main.pack();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}