package tr.com.bgss.interfaces;

import java.util.List;

public interface DALInterfaces<T> { //tüm dal katmanlarýný tek interface üzerinden yazmak icin generic yaptýk
	
	 void Insert(T entity);
	 List<T> GetAll();
	 void Delete (T entity);
	 void Update(T entity);
	 List<T> GetById(int id);

}
