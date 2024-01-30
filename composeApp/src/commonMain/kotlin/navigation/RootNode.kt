package navigation

import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.utils.material3.AppyxMaterial3NavNode

private val navItems = NavItem.entries.toList()

class RootNode(
    context: NodeContext,
) : AppyxMaterial3NavNode<NavItem>(
    nodeContext = context,
    navTargets = navItems,
    navTargetResolver = NavItem.resolver
)