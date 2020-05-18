package kpfu.itis.covid.presentation.list.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_country.view.*
import kpfu.itis.covid.R
import kpfu.itis.covid.data.network.models.CountryCovidInfo

class CountriesViewHolder(
    override val containerView: View,
    private val clickLambda: (Long) -> Unit,
    private val download: (ImageView, String) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Long) -> Unit, download: (ImageView, String) -> Unit) =
            CountriesViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_card_view_country, parent, false),
                clickLambda,
                download
            )
    }

    fun bind(countryCovidInfo: CountryCovidInfo) {
        containerView.apply {
            countryCovidInfo.apply {
                tv_name.text = country
                tv_cases_value.text = cases.toString()
                tv_death_value.text = deaths.toString()
                tv_recovered_value.text = recovered.toString()
                download(iv_flag, countryInfo.flag)
                itemView.setOnClickListener {
                    clickLambda(countryInfo._id)
                }
            }
        }
    }

}
