package br.com.mvbos.lgj;

import br.com.mvbos.lgj.base.Elemento;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Barrier extends Elemento {

    private ArrayList<Integer> tirosX = new ArrayList<Integer>();
    private ArrayList<Integer> tirosY = new ArrayList<Integer>();
    private ArrayList<Integer> tirosH = new ArrayList<Integer>();
    private int life = 20;
    private boolean hit = false;
    private int shotH = 5;
    public Barrier(){
        setAltura(25);
        setLargura(60);
    }


    public void addShotX(int px,int H){
        if(tirosX.contains((Integer) px)){
            tirosH.set(tirosX.indexOf((Integer) px), tirosH.get(tirosX.indexOf((Integer) px)) + 5);
        }
        else{
            tirosX.add((Integer) px);
            tirosY.add((Integer) getPy());
            tirosH.add((Integer) H + 2);
        }


    }



    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public void atualiza(Graphics2D g, Elemento e){

    }

    public void damage(){
        this.life--;
        if (life <= 0){
            this.setAtivo(false);

        }
    }

    @Override
    public void desenha(Graphics2D g) {
       if(isAtivo()) {
                if(life == 20) {
                    g.setColor(Color.GREEN);
                    g.fillRect(getPx(), getPy(), getLargura(), getAltura());
                    g.fillRect(getPx(), getPy() + getAltura(), getAltura() - 5, getAltura());
                    g.fillRect(getPx() + getLargura() - getAltura() + 5, getPy() + getAltura(), getAltura() - 5, getAltura());
                }
                else {
                    g.setColor(Color.GREEN);
                    g.fillRect(getPx(), getPy(), getLargura(), getAltura());
                    g.fillRect(getPx(), getPy() + getAltura(), getAltura() - 5, getAltura());
                    g.fillRect(getPx() + getLargura() - getAltura() + 5, getPy() + getAltura(), getAltura() - 5, getAltura());
                    for(int i = 0; i < tirosX.size(); i++) {
                        g.clearRect(tirosX.get(i),tirosY.get(i), 7, tirosH.get(i));
                    }
                }

       }

    }

}
