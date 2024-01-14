package studentManagementSystem;

import java.util.Collection;

public interface StudentInterface<T,K> {

		void createNew(T t);
		
		Collection<T> getAll();
		
		T getOneById(K id);
		
		void update(T t);
		
		void deleteById(K id);
}
