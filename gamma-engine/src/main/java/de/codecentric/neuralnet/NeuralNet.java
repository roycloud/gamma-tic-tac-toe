package de.codecentric.neuralnet;

import de.codecentric.game.tictactoe.board.Board;
import de.codecentric.neuralnet.layer.HiddenLayer;
import de.codecentric.neuralnet.layer.InputLayer;
import de.codecentric.neuralnet.layer.OutputLayer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class NeuralNet {

    private InputLayer inputLayer;

    private HiddenLayer hiddenLayer;

    private OutputLayer outputLayer;


    @PostConstruct
    public void initialize() {

        inputLayer = new InputLayer();
        inputLayer.initialize(9);

        hiddenLayer = new HiddenLayer();
        hiddenLayer.initialize(9);

        outputLayer = new OutputLayer();
        outputLayer.initialize(1);
    }


    public void print() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("I n p u t  L a y e r");
        System.out.println("==================================================");
        inputLayer.print();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("H i d d e n  L a y e r");
        System.out.println("==================================================");
        hiddenLayer.print();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("O u t p u t  L a y e r");
        System.out.println("==================================================");
        outputLayer.print();
    }

    public int calculate(Board board) {
        List<Integer> validMoves = board.validMoves();
        return validMoves.get(0);
    }
}