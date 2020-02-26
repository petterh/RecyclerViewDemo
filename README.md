# RecyclerViewDemo

This sample demonstrates how to use an Android [`RecyclerView`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html).

It includes an implementation of an [`AutoCompleteTextView`](https://developer.android.com/reference/android/widget/AutoCompleteTextView) that forces the drop-down to drop **down** (rather than up).

## Layout

```xml
<android.support.v7.widget.RecyclerView
    android:id="@+id/recycler_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

## Code

```java
public class MainActivity extends AppCompatActivity {

    private static final String[] ITEMS = { "One", "Two", "Three", "Four", "Five" };

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(TextView itemView) {
            super(itemView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(MainActivity.this);
                return new MyViewHolder(textView);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyViewHolder viewHolder = (MyViewHolder) holder;
                TextView itemView = (TextView) viewHolder.itemView;
                itemView.setText(ITEMS[position]);
            }

            @Override
            public int getItemCount() {
                return ITEMS.length;
            }
        });
    }
}
```
