package be.ucm.restControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    class Square{
        private int id;
        private String squareAttr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSquareAttr() {
            return squareAttr;
        }

        public void setSquareAttr(String squareAttr) {
            this.squareAttr = squareAttr;
        }
    }
    class SpecialSquare extends Square{
        private double attrSpecialSquare;

        public double getAttrSpecialSquare() {
            return attrSpecialSquare;
        }

        public void setAttrSpecialSquare(double attrSpecialSquare) {
            this.attrSpecialSquare = attrSpecialSquare;
        }
    }
    @GetMapping("")
    public List<Square> test(){
        List<Square> l = new ArrayList<>();
        Square ss = new Square();
        ss.setId(1);
        //ss.setAttrSpecialSquare(45.4);
        ss.setSquareAttr("done");
        l.add(ss);
        SpecialSquare ss2 = new SpecialSquare();
        ss2.setId(1);
        ss2.setAttrSpecialSquare(45.4);
        ss2.setSquareAttr("done");
        l.add(ss2);
        return l;
    }
}
