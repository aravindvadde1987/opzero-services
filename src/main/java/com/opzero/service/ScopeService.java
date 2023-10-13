package com.opzero.service;

import com.opzero.entity.Scope;

import java.util.List;
import java.util.Optional;

public interface ScopeService {
	Scope saveScope(Scope scope);

	Optional<Scope> getScope(Long scopeId);

	Scope updateScope(Scope scope);

	List<Scope> getScopes();
}
