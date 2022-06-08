package us.jonesabode.graphqldemo.datafetchers

import com.netflix.dgs.codegen.generated.types.Show
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class ShowDataFetcher {

    var showData = listOf<Show>(
        Show("Ozark", 2017),
        Show("Stranger Things", 2016)
    )
    @DgsQuery
    fun shows(@InputArgument titleFilter: String?) : List<Show> {
        if (titleFilter != null) return showData.filter { it.title.contains(titleFilter) }
        return showData
    }
}