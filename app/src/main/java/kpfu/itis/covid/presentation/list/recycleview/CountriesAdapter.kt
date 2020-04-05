package kpfu.itis.covid.presentation.list.recycleview

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kpfu.itis.covid.data.network.models.CountryCovidInfo

class CountriesAdapter(
    private var dataSource: List<CountryCovidInfo>,
    private val clickLambda: (Long) -> Unit,
    private val download: (ImageView, String) -> Unit
) : RecyclerView.Adapter<CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder =
        CountriesViewHolder.create(parent, clickLambda, download)

    override fun getItemCount(): Int = dataSource.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) =
        holder.bind(dataSource[position])

}
