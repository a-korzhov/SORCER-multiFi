/*
 * Copyright 2013 the original author or authors.
 * Copyright 2013 SorcerSoft.org.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sorcer.core.provider;

import net.jini.core.transaction.Transaction;
import net.jini.core.transaction.TransactionException;
import sorcer.service.*;

import java.rmi.RemoteException;

/**
 * A management of a mogram execution (exerting a federation of service providers)
 * with given parameters for its actualized federation.
 *
 * In particular, a service container ServiceProvider, ServiceShell,
 * and system service beans of type SystemServiceBean are exerters.
 *
 * @author Mike Sobolewski
 */
public interface Exertion extends Service {

	/**
	 * Exerts this mogram by the assigned service provider if it is set. If a service
	 * provider is not set then at runtime it bounds to any available provider
	 * that matches this mogram's signature of the <code>PROCESS</code> fiType.
	 * Service exertions and models are instances of mograms.
	 *
	 * @param txn
	 *            The transaction (if any) under which to exert.
	 * @return a resulting exertion
	 * @throws net.jini.core.transaction.TransactionException
	 *             if a transaction error occurs
	 * @throws RoutineException
	 *             if processing this exertion causes an error
	 */
	public <T extends Mogram> T exert(Transaction txn, Arg... args) throws MogramException, RemoteException;

	public <T extends Mogram> T exert(Arg... args) throws MogramException, RemoteException;
}