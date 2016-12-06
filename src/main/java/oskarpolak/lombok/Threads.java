package oskarpolak.lombok;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
 
  	ExecutorService exec;
	
	 public Threads() { 
		 exec = Executors.newFixedThreadPool(2);

		 runFixedThreadPool();
		// runOldThread();
		 
		//simpleLogic();
	 }
	 
	 private void runFixedThreadPool(){
		 // W przypadku gdy wątek jest zablokowany z możliwością odblokowania (sleep, wait), interrupted wyrzuca wyjatek, który trzeba obsłużyć 
		 // i dopiero tam skończyć kod.
		  Runnable r = new Runnable(){
			@Override
			public void run() {
			
			  for(int i = 0; i <= 100; i++){	
				    if (Thread.currentThread().isInterrupted()) return;
					System.out.println("Zadanie 1 (" + i + ")"); 
				
					Thread.yield();
			  }
				
			} 
			  
		  };
		  
		  Runnable r1 = new Runnable(){
				@Override
				public void run() {
					Thread.yield();
				  for(int i = 0; i <= 100; i++){	
					   if (Thread.currentThread().isInterrupted()) return; // dzięki tej istrukcji, znamy status wątku i możemy ręcznie maskować jego pracę.
					System.out.println("Zadanie 2 (" + i + ")"); 
					Thread.yield();
				  }
					
				} 
				  
			  };
			  
			  Runnable r3 = new Runnable(){
					@Override
					public void run() {
					//	Thread.yield();
					  for(int i = 0; i <= 100; i++){	
						    if (Thread.currentThread().isInterrupted()) return; // dzięki tej istrukcji, znamy status wątku i możemy ręcznie maskować jego pracę.
						System.out.println("Zadanie 3 (" + i + ")"); 
						Thread.yield();
					  }
						
					} 
					  
				  };
		  
				  Runnable noweZadanie = new Runnable(){
						@Override
						public void run() {
					           System.out.println(new SimpleCalculator().addition(5, 5));
					           System.out.println("Uruchomiłem się w nowym wątku");
							
						} 
						  
					  };
		  
		  exec.execute(noweZadanie);
		// exec.execute(r);
		//  exec.execute(r1);
		  //blasdlaldsalsdasd
		 // exec.shutdown(); // Mimo shoutdown - trzy wcześniejsze taski się wykonają
		//  exec.execute(r3);
		  exec.shutdownNow();// Pomimo, że ta metoda ma za zadanie zamknać wykonawcę i zakończyć pracę wątków, rozpoczęte zadania i tak się wykonają.
		  // Dlatego, że nie kończy ona kodu, lecz jedynie ustawia status wątku na zakończony. WĄTKI ZAWSZE KOŃCZĄ SIĘ WTEDY I TYLKO WTEDY GDY WYKONA SIĘ METODA RUN.
		  // ustawia interrupted na true;
	
	 }
	
	 

	 private void simpleLogic() { 
		  Runnable r1 = new Runnable(){
				@Override
				public void run() {
			
				  for(int i = 0; i <= 200; i++){	

					System.out.println("Zadanie 2"); 
					Thread.yield();
				  }
				
				} 
				  
			  };
			  
		
			  Runnable r = new Runnable(){
					@Override
					public void run() {
				
					  for(int i = 0; i <= 200; i++){	
	
						System.out.println("Zadanie 1"); 
						Thread.yield();
					  }
				
					} 
					  
				  };
				  
				  new Thread(r1).start();
				  new Thread(r).start();
	 }
	 
	 private void runOldThread() { 
		 // Nie mamy nad nimi kontroli
		 // Nie możemy ich przerwać 
		 // Tracimy na wydajności
		 // Dostęp do zasobów jest niekontrolowany 
				 Operation o = new Operation();
	
				for(int count = 0; count <= 124; count++){
					new Thread1(o).start();
				}
			
				  
				  //System.out.println(oskar);
	 }
	 
	 private class Operation { 
		 private int oskar = 0;
		 synchronized public int operation() { 
			 oskar++;
			 oskar--;
			 return oskar;
		 }
	 }
	 
	 private class Thread1 extends Thread  { 
			Operation operation; 
			
		 public Thread1(Operation o ) { 
			 operation = o;
		 }
		 
		 @Override
			public void run() {
			  for(int i = 0; i <= 100; i++){		
				  operation.operation();
			  }
			 
			   System.out.println(operation.oskar);
				
			} 		  
	 }
}
