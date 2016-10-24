package oskarpolak.lombok;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
 
  	ExecutorService exec;
	
	 public Threads() { 
		 exec = Executors.newFixedThreadPool(2);
		 runFixedThreadPool();
		 //runOldThread();
	 }
	 
	 private void runFixedThreadPool(){
		 // W przypadku gdy wątek jest zablokowany z możliwością odblokowania (sleep, wait), interrupted wyrzuca wyjatek, który trzeba obsłużyć 
		 // i dopiero tam skończyć kod.
		  Runnable r = new Runnable(){
			@Override
			public void run() {
			
			  for(int i = 0; i <= 20; i++){	
				    if (Thread.currentThread().isInterrupted()) return;
					System.out.println("Zadanie 1 (" + i + ")"); 
			  }
				
			} 
			  
		  };
		  
		  Runnable r1 = new Runnable(){
				@Override
				public void run() {
				//	Thread.yield();
				  for(int i = 0; i <= 20; i++){	
					    if (Thread.currentThread().isInterrupted()) return; // dzięki tej istrukcji, znamy status wątku i możemy ręcznie maskować jego pracę.
					System.out.println("Zadanie 2 (" + i + ")"); 
				  }
					
				} 
				  
			  };
		  
		  
		  exec.execute(r);
		  exec.execute(r);
		  exec.execute(r1);
	//	  exec.shutdown(); Mimo shoutdown - trzy wcześniejsze taski się wykonają
		  exec.execute(r1);
		  exec.shutdownNow();// Pomimo, że ta metoda ma za zadanie zamknać wykonawcę i zakończyć pracę wątków, rozpoczęte zadania i tak się wykonają.
		  // Dlatego, że nie kończy ona kodu, lecz jedynie ustawia status wątku na zakończony. WĄTKI ZAWSZE KOŃCZĄ SIĘ WTEDY I TYLKO WTEDY GDY WYKONA SIĘ METODA RUN.
		  // ustawia interrupted na true;
	 }
	 
	 private void runOldThread() { 
		 // Nie mamy nad nimi kontroli
		 // Nie możemy ich przerwać 
		 // Nie mamy callbacków
		 // Dostęp do zasobów jest niekontrolowany 
		  Runnable r = new Runnable(){
				@Override
				public void run() {
				  for(int i = 0; i <= 100; i++){	
					System.out.println("Zadanie 1");
				  }
					
				} 
				  
			  };
			  
			  Runnable r1 = new Runnable(){
					@Override
					public void run() {
					  for(int i = 0; i <= 100; i++){	
						System.out.println("Zadanie 2");
					  }
						
					} 
					  
				  };
				  
				  new Thread(r).start();
				  new Thread(r).start();
				  new Thread(r1).start();
				  new Thread(r1).start();
	 }
	 
	 
}
