package org.walleth.util

import org.walleth.data.chaininfo.ChainInfo
import org.walleth.data.rpc.KEY_IN3_RPC


private const val INFURA_API_KEY = "b032785efb6947ceb18b9e0177053a17"
private fun String.withInfuraKey() = replace("\${INFURA_API_KEY}", INFURA_API_KEY)

fun ChainInfo.getRPCEndpoint() = if (rpc.isNotEmpty()) {
    rpc.random().withInfuraKey()
} else { null }

// the RPC the user explicitly configured for this chain - always the first entry, no random pick
fun ChainInfo.getUserConfiguredRPCEndpoint() = rpc.firstOrNull()?.withInfuraKey()

fun ChainInfo.hasTincubethSupport() = rpc.contains(KEY_IN3_RPC)