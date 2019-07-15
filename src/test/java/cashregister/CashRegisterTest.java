package cashregister;


import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Item item = new Item("apple",13.5);
        Item[] items=new Item[]{item};
        Purchase purchase = new Purchase(items);

        //when
        cashRegister.process(purchase);

        //then
        verify(printer,times(1)).print("apple"+"\t"+13.5+"\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("do some cool things");

        //when
        cashRegister.process(purchase);

        //then
        verify(printer,times(1)).print("do some cool things");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {

    }

}
