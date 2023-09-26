package cars.domain.view;

// view для просмотра временных (агрегативных) данных из SQL
public interface ModelCount {
    String getModelName();
    Long getCount();
}
