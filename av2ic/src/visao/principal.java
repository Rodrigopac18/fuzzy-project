package visao;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class principal {
	public static void main(String[] args) {
		FIS fis = FIS.load("src/resource/tipperMandani.fcl", true); // MANDANI
			
		//APRESENTA AS VARIÃ�VEIS MODELADAS
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
		
        //SETA AS ENTRADAS
	    fis.setVariable("temperatura", 3);
	    fis.setVariable("luminosidade", 2);
	    
	    //AVALIA
	    fis.evaluate();

	    //MOSTRA O GRÃ�FICO DA VARIÃ�VEL DE SAÃ�DA
        Variable tip = fis.getFunctionBlock("tipper").getVariable("velocidade");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        //PRINTA VARIÃ�VEL DE SAÃ�DA    
        System.out.println(tip.getValue());
        
        //MOSTRA CADA REGRA COM O VALOR DE ATIVAÃ‡ÃƒO
        for( Rule r : fis.getFunctionBlock("tipper").getFuzzyRuleBlock("No1").getRules() )
        	System.out.println(r);
	}

}
	
