package be.ucm;

import be.ucm.BL.MathService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockingTest {

    @Mock
    MathService mathService;

    // @InjectMocks ServiceUsedByMathService serviceUsedByMathService;

    @Test//(expected = Exception.class)
    public void mathServiceMocked(){
        // MathService mathService = mock(MathService.class);

        // Le premier appel va générer une exception
        // Les suivants vont renvoyer une valeur : 2 puis 4 puis 10
        // Tous les autres renverront 10 (la dernière valeur)
        when(mathService.multiplication(1,2))
                .thenThrow(new RuntimeException())
                .thenReturn(2d, 4d, 10d);



        // pour ne rien retourner :
        //Mockito.doNothing().when(mathService.multiplication(4d,9d));

        try{
            mathService.multiplication(1,2);
        }
        catch(Exception e){
            System.out.println("catch");
        }
        System.out.println("avant assert");
        Assert.assertEquals(2d, mathService.multiplication(4,9), 0.01);
    }
}
