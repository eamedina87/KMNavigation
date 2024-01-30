package navigation

import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.utils.material3.AppyxMaterial3NavNode
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

private val navItems = NavItem.entries.toList()

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
class RootNode(
    context: NodeContext,
) : AppyxMaterial3NavNode<NavItem>(
    nodeContext = context,
    navTargets = navItems,
    navTargetResolver = NavItem.resolver
)