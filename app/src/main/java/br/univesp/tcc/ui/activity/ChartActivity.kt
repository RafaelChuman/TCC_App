package br.univesp.tcc.ui.activity

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.univesp.tcc.databinding.ActivityChartBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.coroutines.launch


class ChartActivity : Fragment() {
    lateinit var barChart: BarChart

    lateinit var pieChart: PieChart

    lateinit var linearChart: LineChart

    //val purple_700  =  0xFF3700B3
    val purple_200 = 0xFFBB86FC
    val purple_500 = 0xFF6200EE

    private lateinit var binding: ActivityChartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityChartBinding.inflate(inflater, container, false)


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                setBarChar()
                setPieChar()
                setLineChar()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    private fun setBarChar() {

        val colorPrimary = R.attr.colorPrimary
        //val colorPrimary = typedValue.toInt()

        barChart = binding.chartActivityBarChart


        val yAxis = barChart.axisLeft
        yAxis.axisMinimum = 0f // Start at zero
        yAxis.axisMaximum = 250f // Set the maximum value to 100

        val list: ArrayList<BarEntry> = ArrayList()

        list.add(BarEntry(1f, 219f))
        list.add(BarEntry(2f, 220f))
        list.add(BarEntry(3f, 220f))
        list.add(BarEntry(4f, 220f))
        list.add(BarEntry(5f, 219f))
        list.add(BarEntry(6f, 220f))

        val barDataSet = BarDataSet(list, "List")

        barDataSet.setColors(purple_200.toInt())
        barDataSet.valueTextColor = Color.WHITE

        val barData = BarData(barDataSet)

        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Tensão"
        barChart.setBackgroundColor( colorPrimary)
        barChart.legend.isEnabled = false
        barChart.animateY(2000)
    }


    private fun setLineChar() {

        linearChart = binding.chartActivityLinearChart

        val yAxis = linearChart.axisLeft
        yAxis.axisMinimum = 0f // Start at zero
        yAxis.axisMaximum = 50f // Set the maximum value to 100



        val list: ArrayList<Entry> = ArrayList()

        list.add(Entry(1f, 22.5f))
        list.add(Entry(2f, 22.5f))
        list.add(Entry(3f, 22.6f))
        list.add(Entry(4f, 22.5f))
        list.add(Entry(5f, 22.4f))
        list.add(Entry(6f, 22.3f))

        val lineDataSet = LineDataSet(list, "Temperatura")

        lineDataSet.setColors(purple_500.toInt())
        lineDataSet.valueTextColor = Color.WHITE
        lineDataSet.valueTextSize = 14f
        lineDataSet.lineWidth = 2f
        lineDataSet.setDrawFilled(true)
        lineDataSet.setFillColor(purple_200.toInt());
        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)

        val lineData = LineData(lineDataSet)

        linearChart.data = lineData
        linearChart.description.text = "Temperatura"
        linearChart.setGridBackgroundColor(R.color.white)
        linearChart.legend.isEnabled = false
        linearChart.animateY(2000)
    }


    private fun setPieChar() {



        pieChart = binding.chartActivityPieChart




        val list: ArrayList<PieEntry> = ArrayList()

        list.add(PieEntry(81f, "81%" ))
        list.add(PieEntry(19f, "19%" ))

        val pieDataSet = PieDataSet(list, "List")

        pieDataSet.setColors(purple_500.toInt(), purple_200.toInt()) // Customize colors here
        pieDataSet.valueTextColor = Color.WHITE
        pieDataSet.valueTextSize = 15f


        val pieData = PieData(pieDataSet)

        pieChart.data = pieData
        pieChart.description.text = ""
        pieChart.centerText = "Umidade"
        pieChart.legend.isEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.setContentDescription("")
        pieChart.animateY(2000)
    }
}