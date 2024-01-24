package navigation

import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.utils.material3.AppyxMaterial3NavNode
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

private val navItems = NavItem.entries.toList()

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
class RootNode(
    buildContext: BuildContext,
) : AppyxMaterial3NavNode<NavItem>(
    buildContext = buildContext,
    navTargets = navItems,
    navTargetResolver = NavItem.resolver
)