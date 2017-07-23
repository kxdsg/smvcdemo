package com.argus.web.v3.idol;

/**
 * @author xingding
 * @date 17/7/23.
 */
public class PoeticJugglerImpl extends JugglerImpl {
    private PoemService poemService;

    public PoeticJugglerImpl(PoemService poemService){
        super();
        this.poemService = poemService;
    }

    public PoeticJugglerImpl(int beanBags, PoemService poemService){
        super(beanBags);
        this.poemService = poemService;
    }

    public void perform(){
        super.perform();
        System.out.println("while reciting...");
        poemService.recite();
    }
}
