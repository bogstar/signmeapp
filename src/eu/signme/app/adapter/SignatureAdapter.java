package eu.signme.app.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import eu.signme.app.R;
import eu.signme.app.model.Signature;
import eu.signme.app.viewholder.SignaturesRowHolder;

public class SignatureAdapter extends RecyclerView.Adapter<SignaturesRowHolder> {

	private List<Signature> signatures;
	private Context mContext;
	private int myId;

	public SignatureAdapter(Context context, List<Signature> signatures, int userId) {
		this.signatures = signatures;
		this.mContext = context;
		this.myId = userId;
	}

	@Override
	public SignaturesRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.signatures_item, viewGroup, false);
		SignaturesRowHolder mh = new SignaturesRowHolder(v);
		
		return mh;
	}

	@Override
	public void onBindViewHolder(SignaturesRowHolder feedListRowHolder, int i) {
		

		
		if (i % 2 == 0) {
			feedListRowHolder.rlSignature.setBackgroundColor(mContext.getResources().getColor(
					R.color.gray_background));
		} else {
			feedListRowHolder.rlSignature.setBackgroundColor(mContext.getResources().getColor(
					R.color.light_gray_background));
		}
		

		// Getting signature data from a row
		Signature signature = signatures.get(i);

		
		
		
		if (signature.getIUserd() == myId) {
			feedListRowHolder.txtName.setText("Me");
			feedListRowHolder.txtName.setTextColor(mContext.getResources().getColor(
					R.color.signme_green));
		} else {
			// Name of a user
			feedListRowHolder.txtName.setText(signature.getUserName());
			feedListRowHolder.txtName.setTextColor(mContext.getResources().getColor(
					R.color.dark_gray_text));
		}

		if (signature.getStatus() == 0) {
			// Number of a signature
		//	feedListRowHolder.txtCount.setVisibility(View.VISIBLE);
			feedListRowHolder.imgThick.setVisibility(View.GONE);
			feedListRowHolder.txtCount.setText(Integer.toString(i + 1));
		} else {
			feedListRowHolder.imgThick.setVisibility(View.VISIBLE);
		//	feedListRowHolder.txtCount.setVisibility(View.GONE);
		}
		


	}

	@Override
	public int getItemCount() {
		return (null != signatures ? signatures.size() : 0);
	}
}