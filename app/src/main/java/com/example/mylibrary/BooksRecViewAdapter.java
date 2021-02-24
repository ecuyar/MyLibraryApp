package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private Context context;
    private String type = "";
    private Util utils;

    public BooksRecViewAdapter(Context context) {
        this.context = context;
        utils = new Util();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_book_rec_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bookName.setText(books.get(position).getName());
        holder.bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,books.get(position).getName() + " is selected.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("bookId", books.get(position).getId());
                context.startActivity(intent);
            }
        });

        //delete record on long press in seperate list sections
        holder.bookCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Book bo = books.get(position);

                //warn the user before remove the object
                AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                        .setTitle("Remove " + bo.getName() + "?")
                        .setMessage("Are you sure you want to remove this book from list?")
                        .setCancelable(false)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                switch (type) {
                    case "want to read":
                        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (utils.removeWantToReadBook(books.get(position))) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, bo.getName() + " has removed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    case "already read":
                        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (utils.removeAlreadyReadBook(books.get(position))) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, bo.getName() + " has removed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    case "currently reading":
                        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (utils.removeCurrentlyReadingBook(books.get(position))) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, bo.getName() + " has removed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bookImage;
        private TextView bookName;
        private CardView bookCard;

        public ViewHolder(View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.bookName);
            bookCard = itemView.findViewById(R.id.bookCard);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }


}
